package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;

public class ZipRSAUtil {

	// Ҫѹ����Ŀ¼
	private static String srcPath = "F:\\testml";
	// ѹ����Ĵ���ļ�
	private static String destZip = "F:\\test.zip";
	// ѹ�����ܺ��publickey
	private static String keyfile = "F:\\key.txt";

	// ��ѹ�����ļ������ڵ�λ��
	private static String fileDir = "F:\\key";

	private static PrivateKey privateKey;

	private static PublicKey publicKey;

	private static void directoryZip(ZipOutputStream out, File f, String base)
			throws Exception {
		// ����������Ŀ¼
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			// ����ѹ������Ŀ¼
			out.putNextEntry(new ZipEntry(base + "/"));
			if (base.length() == 0) {
				base = "";
			} else {
				base = base + "/";
			}
			for (int i = 0; i < fl.length; i++) {
				directoryZip(out, fl[i], base + fl[i].getName());
			}
		} else {
			// ��ѹ���ļ�����rar��
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			byte[] bb = new byte[2048];
			int aa = 0;
			while ((aa = in.read(bb)) != -1) {
				out.write(bb, 0, aa);
			}
			in.close();
		}
	}

	/**
	 * ѹ���ļ�
	 * 
	 * @param zos
	 * @param file
	 * @throws Exception
	 */
	private static void fileZip(ZipOutputStream zos, File file)
			throws Exception {
		// ����
		if (file.isFile()) {
			zos.putNextEntry(new ZipEntry(file.getName()));
			FileInputStream fis = new FileInputStream(file);
			byte[] bb = new byte[2048];
			int aa = 0;
			while ((aa = fis.read(bb)) != -1) {
				zos.write(bb, 0, aa);
			}
			fis.close();
			System.out.println(file.getName());
		} else {
			directoryZip(zos, file, "");
		}
	}

	/**
	 * ��ѹ���ļ�
	 * 
	 * @param zis
	 * @param file
	 * @throws Exception
	 */
	private static void fileUnZip(ZipInputStream zis, File file)
			throws Exception {
		ZipEntry zip = zis.getNextEntry();
		if (zip == null)
			return;
		String name = zip.getName();
		File f = new File(file.getAbsolutePath() + "/" + name);
		if (zip.isDirectory()) {
			f.mkdirs();
			fileUnZip(zis, file);
		} else {
			f.createNewFile();
			FileOutputStream fos = new FileOutputStream(f);
			byte b[] = new byte[2048];
			int aa = 0;
			while ((aa = zis.read(b)) != -1) {
				fos.write(b, 0, aa);
			}
			fos.close();
			fileUnZip(zis, file);
		}
	}

	/**
	 * ��directoryĿ¼�µ��ļ�ѹ��������Ϊָ�����ļ�zipFile
	 * 
	 * @param directory
	 * @param zipFile
	 */
	private static void zip(String directory, String zipFile) {
		try {
			// ����
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(
					zipFile));
			fileZip(zos, new File(directory));
			zos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ѹ���ļ�zipFile������directoryĿ¼��
	 * 
	 * @param directory
	 * @param zipFile
	 */
	private static void unZip(String directory, String zipFile) {
		try {
			ZipInputStream zis = new ZipInputStream(
					new FileInputStream(zipFile));
			File f = new File(directory);
			f.mkdirs();
			fileUnZip(zis, f);
			zis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����key��·���ļ���ó־û����ļ���key
	 * <P>
	 * ����: RsaEncrypt.getKey("c:/systemkey/private.key");
	 * 
	 * @param keyPath
	 * @return
	 */
	public static Key getKey(String keyPath) throws Exception {
		Key key = null;
		FileInputStream fis = new FileInputStream(keyPath);
		ObjectInputStream ofs = new ObjectInputStream(fis);
		key = (Key) ofs.readObject();
		return key;
	}

	/**
	 * ���ļ�srcFile���ܺ�洢ΪdestFile
	 * 
	 * @param srcFile
	 * @param destFile
	 */
	private static void encrypt(String srcFile, String destFile, Key privateKey)
			throws Exception {

		Cipher cipher = Cipher.getInstance("RSA");

		cipher.init(Cipher.ENCRYPT_MODE, privateKey);

		FileInputStream fis = new FileInputStream(srcFile);

		FileOutputStream fos = new FileOutputStream(destFile);

		byte[] b = new byte[53];

		while (fis.read(b) != -1) {
			fos.write(cipher.doFinal(b));
		}
		fos.flush();
		fos.close();
		fis.close();
	}

	/**
	 * ���ļ�srcFile���ܺ�洢ΪdestFile
	 * 
	 * @param srcFile
	 * @param destFile
	 * @param privateKey
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static void decrypt(String srcFile, String destFile, Key privateKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		byte[] b = new byte[64];
		while (fis.read(b) != -1) {
			fos.write(cipher.doFinal(b));
		}
		fos.close();
		fis.close();
	}

	/**
	 * ��Ŀ¼srcFile�µ������ļ�Ŀ¼������ѹ�������,Ȼ�󱣴�Ϊdestfile
	 * 
	 * @param srcFile
	 *            Ҫ������Ŀ¼ ��c:/test/test
	 * @param destfile
	 *            ѹ�����ܺ��ŵ��ļ��� ��c:/����ѹ���ļ�.zip
	 * @param keyfile
	 *            ��Կ��ŵص�
	 */
	public static void encryptZip(String srcFile, String destfile,
			String keyfile) throws Exception {
		SecureRandom sr = new SecureRandom();
		KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
		kg.initialize(512, sr);
		// ��������Կ��
		KeyPair kp = kg.generateKeyPair();
		// ���˽��
		ZipRSAUtil.privateKey = kp.getPrivate();
		// ��ù�Կ
		ZipRSAUtil.publicKey = kp.getPublic();

		File f = new File(keyfile);
		f.createNewFile();
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream dos = new ObjectOutputStream(fos);
		dos.writeObject(ZipRSAUtil.publicKey);
		File temp = new File(UUID.randomUUID().toString() + ".zip");
		zip(srcFile, temp.getAbsolutePath());

		// ��ѹ���ļ�����
		encrypt(temp.getAbsolutePath(), destfile, ZipRSAUtil.privateKey);
		temp.delete();
	}

	/**
	 * ���ļ�srcfile�����Ƚ��ܺ��ѹ��,Ȼ���ѹ����Ŀ¼destfile��
	 * 
	 * @param srcfile
	 *            Ҫ���ܺͽ�ѹ�����ļ��� ��c:/Ŀ��.zip
	 * @param destfile
	 *            ��ѹ�����Ŀ¼ ��c:/abc
	 * @param publicKey
	 *            ��Կ
	 */
	public static void decryptUnzip(String srcfile, String destfile,
			Key publicKey) throws Exception {

		// �ȶ��ļ�����
		File temp = new File(UUID.randomUUID().toString() + ".zip");
		temp.deleteOnExit();
		decrypt(srcfile, temp.getAbsolutePath(), publicKey);
		// ��ѹ��
		unZip(destfile, temp.getAbsolutePath());
		temp.delete();
	}

	public static Key getPublicKey(String keyDir) {

		Key key = null;

		try {
			FileInputStream fin = new FileInputStream(keyDir);

			ObjectInputStream ois = new ObjectInputStream(fin);

			key = (Key) ois.readObject();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return key;

	}

	public static void main(String args[]) {
		// ����ѹ��
//		 doCompress();

//		 ���н�ѹ��
		doUnCompress();

	}

	/**
	 * ����ѹ��
	 */
	public static void doCompress() {
		try {
			ZipRSAUtil.encryptZip(srcPath, destZip, keyfile);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * ��ѹ��
	 */
	public static void doUnCompress() {
		// ��ȡ��Կ���н���
		Key key = ZipRSAUtil.getPublicKey(keyfile);

		try {
			ZipRSAUtil.decryptUnzip(destZip, fileDir, key);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}