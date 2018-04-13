package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NetFlags;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;
import org.hyperic.sigar.Who;
 
public class RuntimeTest {
    public static void main(String[] args) {
        try {
            // System��Ϣ����jvm��ȡ
            property();
            System.out.println("----------------------------------");
            // cpu��Ϣ
            cpu();
            System.out.println("----------------------------------");
            // �ڴ���Ϣ
            memory();
            System.out.println("----------------------------------");
            // ����ϵͳ��Ϣ
            os();
            System.out.println("----------------------------------");
            // �û���Ϣ
            who();
            System.out.println("----------------------------------");
            // �ļ�ϵͳ��Ϣ
            file();
            System.out.println("----------------------------------");
            // ������Ϣ
            net();
            System.out.println("----------------------------------");
            // ��̫����Ϣ
            ethernet();
            System.out.println("----------------------------------");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
 
    private static void property() throws UnknownHostException {
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        InetAddress addr;
        addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");// ��ȡ�û���
        String computerName = map.get("COMPUTERNAME");// ��ȡ�������
        String userDomain = map.get("USERDOMAIN");// ��ȡ���������
        System.out.println("�û���:    " + userName);
        System.out.println("�������:    " + computerName);
        System.out.println("���������:    " + userDomain);
        System.out.println("����ip��ַ:    " + ip);
        System.out.println("����������:    " + addr.getHostName());
        System.out.println("JVM����ʹ�õ����ڴ�:    " + r.totalMemory());
        System.out.println("JVM����ʹ�õ�ʣ���ڴ�:    " + r.freeMemory());
        System.out.println("JVM����ʹ�õĴ���������:    " + r.availableProcessors());
        System.out.println("Java�����л����汾��    " + props.getProperty("java.version"));
        System.out.println("Java�����л�����Ӧ�̣�    " + props.getProperty("java.vendor"));
        System.out.println("Java��Ӧ�̵�URL��    " + props.getProperty("java.vendor.url"));
        System.out.println("Java�İ�װ·����    " + props.getProperty("java.home"));
        System.out.println("Java��������淶�汾��    " + props.getProperty("java.vm.specification.version"));
        System.out.println("Java��������淶��Ӧ�̣�    " + props.getProperty("java.vm.specification.vendor"));
        System.out.println("Java��������淶���ƣ�    " + props.getProperty("java.vm.specification.name"));
        System.out.println("Java�������ʵ�ְ汾��    " + props.getProperty("java.vm.version"));
        System.out.println("Java�������ʵ�ֹ�Ӧ�̣�    " + props.getProperty("java.vm.vendor"));
        System.out.println("Java�������ʵ�����ƣ�    " + props.getProperty("java.vm.name"));
        System.out.println("Java����ʱ�����淶�汾��    " + props.getProperty("java.specification.version"));
        System.out.println("Java����ʱ�����淶��Ӧ�̣�    " + props.getProperty("java.specification.vender"));
        System.out.println("Java����ʱ�����淶���ƣ�    " + props.getProperty("java.specification.name"));
        System.out.println("Java�����ʽ�汾�ţ�    " + props.getProperty("java.class.version"));
        System.out.println("Java����·����    " + props.getProperty("java.class.path"));
        System.out.println("���ؿ�ʱ������·���б�    " + props.getProperty("java.library.path"));
        System.out.println("Ĭ�ϵ���ʱ�ļ�·����    " + props.getProperty("java.io.tmpdir"));
        System.out.println("һ��������չĿ¼��·����    " + props.getProperty("java.ext.dirs"));
        System.out.println("����ϵͳ�����ƣ�    " + props.getProperty("os.name"));
        System.out.println("����ϵͳ�Ĺ��ܣ�    " + props.getProperty("os.arch"));
        System.out.println("����ϵͳ�İ汾��    " + props.getProperty("os.version"));
        System.out.println("�ļ��ָ�����    " + props.getProperty("file.separator"));
        System.out.println("·���ָ�����    " + props.getProperty("path.separator"));
        System.out.println("�зָ�����    " + props.getProperty("line.separator"));
        System.out.println("�û����˻����ƣ�    " + props.getProperty("user.name"));
        System.out.println("�û�����Ŀ¼��    " + props.getProperty("user.home"));
        System.out.println("�û��ĵ�ǰ����Ŀ¼��    " + props.getProperty("user.dir"));
    }
 
    private static void memory() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        // �ڴ�����
        System.out.println("�ڴ�����:    " + mem.getTotal() / 1024L + "K av");
        // ��ǰ�ڴ�ʹ����
        System.out.println("��ǰ�ڴ�ʹ����:    " + mem.getUsed() / 1024L + "K used");
        // ��ǰ�ڴ�ʣ����
        System.out.println("��ǰ�ڴ�ʣ����:    " + mem.getFree() / 1024L + "K free");
        Swap swap = sigar.getSwap();
        // ����������
        System.out.println("����������:    " + swap.getTotal() / 1024L + "K av");
        // ��ǰ������ʹ����
        System.out.println("��ǰ������ʹ����:    " + swap.getUsed() / 1024L + "K used");
        // ��ǰ������ʣ����
        System.out.println("��ǰ������ʣ����:    " + swap.getFree() / 1024L + "K free");
    }
 
    private static void cpu() throws SigarException {
        Sigar sigar = new Sigar();
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpuList[] = null;
        cpuList = sigar.getCpuPercList();
        for (int i = 0; i < infos.length; i++) {// �����ǵ���CPU���Ƕ�CPU������
            CpuInfo info = infos[i];
            System.out.println("��" + (i + 1) + "��CPU��Ϣ");
            System.out.println("CPU������MHz:    " + info.getMhz());// CPU������MHz
            System.out.println("CPU������:    " + info.getVendor());// ���CPU���������磺Intel
            System.out.println("CPU���:    " + info.getModel());// ���CPU������磺Celeron
            System.out.println("CPU��������:    " + info.getCacheSize());// ����洢������
            printCpuPerc(cpuList[i]);
        }
    }
 
    private static void printCpuPerc(CpuPerc cpu) {
        System.out.println("CPU�û�ʹ����:    " + CpuPerc.format(cpu.getUser()));// �û�ʹ����
        System.out.println("CPUϵͳʹ����:    " + CpuPerc.format(cpu.getSys()));// ϵͳʹ����
        System.out.println("CPU��ǰ�ȴ���:    " + CpuPerc.format(cpu.getWait()));// ��ǰ�ȴ���
        System.out.println("CPU��ǰ������:    " + CpuPerc.format(cpu.getNice()));//
        System.out.println("CPU��ǰ������:    " + CpuPerc.format(cpu.getIdle()));// ��ǰ������
        System.out.println("CPU�ܵ�ʹ����:    " + CpuPerc.format(cpu.getCombined()));// �ܵ�ʹ����
    }
 
    private static void os() {
        OperatingSystem OS = OperatingSystem.getInstance();
        // ����ϵͳ�ں������磺 386��486��586��x86
        System.out.println("����ϵͳ:    " + OS.getArch());
        System.out.println("����ϵͳCpuEndian():    " + OS.getCpuEndian());//
        System.out.println("����ϵͳDataModel():    " + OS.getDataModel());//
        // ϵͳ����
        System.out.println("����ϵͳ������:    " + OS.getDescription());
        // ����ϵͳ����
        // System.out.println("OS.getName():    " + OS.getName());
        // System.out.println("OS.getPatchLevel():    " + OS.getPatchLevel());//
        // ����ϵͳ������
        System.out.println("����ϵͳ������:    " + OS.getVendor());
        // ��������
        System.out.println("����ϵͳ��������:    " + OS.getVendorCodeName());
        // ����ϵͳ����
        System.out.println("����ϵͳ����:    " + OS.getVendorName());
        // ����ϵͳ��������
        System.out.println("����ϵͳ��������:    " + OS.getVendorVersion());
        // ����ϵͳ�İ汾��
        System.out.println("����ϵͳ�İ汾��:    " + OS.getVersion());
    }
 
    private static void who() throws SigarException {
        Sigar sigar = new Sigar();
        Who who[] = sigar.getWhoList();
        if (who != null && who.length > 0) {
            for (int i = 0; i < who.length; i++) {
                // System.out.println("��ǰϵͳ���̱��е��û���" + String.valueOf(i));
                Who _who = who[i];
                System.out.println("�û�����̨:    " + _who.getDevice());
                System.out.println("�û�host:    " + _who.getHost());
                // System.out.println("getTime():    " + _who.getTime());
                // ��ǰϵͳ���̱��е��û���
                System.out.println("��ǰϵͳ���̱��е��û���:    " + _who.getUser());
            }
        }
    }
 
    private static void file() throws Exception {
        Sigar sigar = new Sigar();
        FileSystem fslist[] = sigar.getFileSystemList();
        for (int i = 0; i < fslist.length; i++) {
            System.out.println("�������̷�����" + i);
            FileSystem fs = fslist[i];
            // �������̷�����
            System.out.println("�̷�����:    " + fs.getDevName());
            // �������̷�����
            System.out.println("�̷�·��:    " + fs.getDirName());
            System.out.println("�̷���־:    " + fs.getFlags());//
            // �ļ�ϵͳ���ͣ����� FAT32��NTFS
            System.out.println("�̷�����:    " + fs.getSysTypeName());
            // �ļ�ϵͳ�����������籾��Ӳ�̡������������ļ�ϵͳ��
            System.out.println("�̷�������:    " + fs.getTypeName());
            // �ļ�ϵͳ����
            System.out.println("�̷��ļ�ϵͳ����:    " + fs.getType());
            FileSystemUsage usage = null;
            usage = sigar.getFileSystemUsage(fs.getDirName());
            switch (fs.getType()) {
            case 0: // TYPE_UNKNOWN ��δ֪
                break;
            case 1: // TYPE_NONE
                break;
            case 2: // TYPE_LOCAL_DISK : ����Ӳ��
                // �ļ�ϵͳ�ܴ�С
                System.out.println(fs.getDevName() + "�ܴ�С:    " + usage.getTotal() + "KB");
                // �ļ�ϵͳʣ���С
                System.out.println(fs.getDevName() + "ʣ���С:    " + usage.getFree() + "KB");
                // �ļ�ϵͳ���ô�С
                System.out.println(fs.getDevName() + "���ô�С:    " + usage.getAvail() + "KB");
                // �ļ�ϵͳ�Ѿ�ʹ����
                System.out.println(fs.getDevName() + "�Ѿ�ʹ����:    " + usage.getUsed() + "KB");
                double usePercent = usage.getUsePercent() * 100D;
                // �ļ�ϵͳ��Դ��������
                System.out.println(fs.getDevName() + "��Դ��������:    " + usePercent + "%");
                break;
            case 3:// TYPE_NETWORK ������
                break;
            case 4:// TYPE_RAM_DISK ������
                break;
            case 5:// TYPE_CDROM ������
                break;
            case 6:// TYPE_SWAP ��ҳ�潻��
                break;
            }
            System.out.println(fs.getDevName() + "������    " + usage.getDiskReads());
            System.out.println(fs.getDevName() + "д�룺    " + usage.getDiskWrites());
        }
        return;
    }
 
    private static void net() throws Exception {
        Sigar sigar = new Sigar();
        String ifNames[] = sigar.getNetInterfaceList();
        for (int i = 0; i < ifNames.length; i++) {
            String name = ifNames[i];
            NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
            System.out.println("�����豸��:    " + name);// �����豸��
            System.out.println("IP��ַ:    " + ifconfig.getAddress());// IP��ַ
            System.out.println("��������:    " + ifconfig.getNetmask());// ��������
            if ((ifconfig.getFlags() & 1L) <= 0L) {
                System.out.println("!IFF_UP...skipping getNetInterfaceStat");
                continue;
            }
            NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
            System.out.println(name + "���յ��ܰ�����:" + ifstat.getRxPackets());// ���յ��ܰ�����
            System.out.println(name + "���͵��ܰ�����:" + ifstat.getTxPackets());// ���͵��ܰ�����
            System.out.println(name + "���յ������ֽ���:" + ifstat.getRxBytes());// ���յ������ֽ���
            System.out.println(name + "���͵����ֽ���:" + ifstat.getTxBytes());// ���͵����ֽ���
            System.out.println(name + "���յ��Ĵ������:" + ifstat.getRxErrors());// ���յ��Ĵ������
            System.out.println(name + "�������ݰ�ʱ�Ĵ�����:" + ifstat.getTxErrors());// �������ݰ�ʱ�Ĵ�����
            System.out.println(name + "����ʱ�����İ���:" + ifstat.getRxDropped());// ����ʱ�����İ���
            System.out.println(name + "����ʱ�����İ���:" + ifstat.getTxDropped());// ����ʱ�����İ���
        }
    }
 
    private static void ethernet() throws SigarException {
        Sigar sigar = null;
        sigar = new Sigar();
        String[] ifaces = sigar.getNetInterfaceList();
        for (int i = 0; i < ifaces.length; i++) {
            NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
            if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
                    || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
                continue;
            }
            System.out.println(cfg.getName() + "IP��ַ:" + cfg.getAddress());// IP��ַ
            System.out.println(cfg.getName() + "���ع㲥��ַ:" + cfg.getBroadcast());// ���ع㲥��ַ
            System.out.println(cfg.getName() + "����MAC��ַ:" + cfg.getHwaddr());// ����MAC��ַ
            System.out.println(cfg.getName() + "��������:" + cfg.getNetmask());// ��������
            System.out.println(cfg.getName() + "����������Ϣ:" + cfg.getDescription());// ����������Ϣ
            System.out.println(cfg.getName() + "��������" + cfg.getType());//
        }
    }
}