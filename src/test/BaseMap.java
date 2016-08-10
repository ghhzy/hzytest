package test;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
/**
 * @author hzy
 * @category 不需要去new map 
 * 			  不需要每次取值时手动强转类型
 *
 */
public class BaseMap<K,V> extends HashMap<K,V> {
	
	
	public BaseMap() {
		
	}

	private static final long serialVersionUID = 1L;
	
	public Boolean getBoolean(Object name) {
		
        Object obj = get(name);

        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        } else {
            throw new IllegalArgumentException("getBoolean could not map the object '" + obj.toString() + "' to Boolean type, unknown object type: " + obj.getClass().getName());
        }
    }
	
	
	 public String getString(Object name) {
        // might be nice to add some ClassCastException handling... and auto conversion? hmmm...
        Object object = get(name);
        if (object == null) return null;
        if (object instanceof java.lang.String) {
            return (String) object;
        } else {
            return object.toString();
        }
    }

    public java.sql.Timestamp getTimestamp(Object name) {
        return (java.sql.Timestamp) get(name);
    }

    public java.sql.Time getTime(Object name) {
        return (java.sql.Time) get(name);
    }

    public java.sql.Date getSqlDate(Object name) {
        return (java.sql.Date) get(name);
    }
    
    public java.util.Date getDate(Object name) {
    	return (java.util.Date) get(name);
    }

    public Integer getInteger(Object name) {
        return (Integer) get(name);
    }

    public Long getLong(Object name) {
        return (Long) get(name);
    }

    public Float getFloat(Object name) {
        return (Float) get(name);
    }

    public Double getDouble(Object name) {
        // this "hack" is needed for now until the Double/BigDecimal issues are all resolved
        Object value = get(name);
        if (value instanceof BigDecimal) {
            return Double.valueOf(((BigDecimal) value).doubleValue());
        } else {
            return (Double) value;
        }
    }

    public BigDecimal getBigDecimal(Object name) {
        // this "hack" is needed for now until the Double/BigDecimal issues are all resolved
        // NOTE: for things to generally work properly BigDecimal should really be used as the java-type in the field type def XML files
        Object value = get(name);
        if (value instanceof Double) {
            return BigDecimal.valueOf(((Double) value).doubleValue());
        } else {
            return (BigDecimal) value;
        }
    }

    public byte[] getBytes(Object name) {
        Object value = get(name);
        if (value == null) {
            return null;
        }
        if (value instanceof Blob) {
            try {
                Blob valueBlob = (Blob) value;
                return valueBlob.getBytes(1, (int) valueBlob.length());
            } catch (SQLException e) {
                return null;
            }
        }
        if (value instanceof byte[]) {
            return (byte[]) value;
        }else{
        	return null;
        }
    }
}
