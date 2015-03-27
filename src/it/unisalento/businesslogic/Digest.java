package it.unisalento.businesslogic;

import java.security.MessageDigest;


public class Digest {
	private byte[] digest;
	public Digest(String word){
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(word.getBytes());
			digest=md.digest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getResult(){
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}
}
