package pri.ivj.encriptacion;



import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class GestorEncriptacionMD5 {
	private String _secretKey ="";	
	
	
	public GestorEncriptacionMD5(String secretKey) {
		this._secretKey = secretKey != null ? (secretKey.isEmpty() ? "Sismed08": secretKey) : "Sismed08" ;
	}
	
	public String Encriptar(String texto) {		
		
		String base64EncryptedString = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte[] digestOfPassword = md.digest(_secretKey.getBytes("utf-8"));
			
			byte [] keyBytes = Arrays.copyOf(digestOfPassword,24);
			
			SecretKey key = new SecretKeySpec(keyBytes, "DESede");
			
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			
			byte[] plainTextBytes = texto.getBytes("utf-8");
			byte[] buf = cipher.doFinal(plainTextBytes);
			byte[] base64Bytes = Base64.encodeBase64(buf);
			
			base64EncryptedString = new String(base64Bytes);
			
			
		}catch (Exception ex) {
			// mostrar ventana emergente con mensaje de error
		}
		
		return base64EncryptedString;
	}	
	
	
	public String DesEncritar(String texto) {		
		String base64DecryptedString = "";
		
		try {
			byte [] message = Base64.decodeBase64(texto.getBytes("utf-8"));
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte [] digestOfPassword = md.digest(_secretKey.getBytes("utf-8"));
			
			byte [] keyBytes = Arrays.copyOf(digestOfPassword, 24);
			
			SecretKey key = new SecretKeySpec(keyBytes, "DESede");
			
			Cipher decipher = Cipher.getInstance("DESede");
			decipher.init(Cipher.DECRYPT_MODE, key);
			
			byte[] plainText = decipher.doFinal(message);
			
			base64DecryptedString = new String(plainText,"UTF-8");
			
		}catch(Exception ex) {
			
		}			
		return base64DecryptedString;
	}
}
