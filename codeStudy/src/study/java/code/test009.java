package study.java.code;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

public class test009 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String base64Member = "YXZhLmNvZGUuTWVtYmVyFreIYm93IywCAANJAANhZ2VMAAVlbWFpbHQAEkxqYXZhL2xhbmcvU3RyaW5nO0wABG5hbWVxAH4AAXhwAAAAGXQAFmRlbGl2ZXJ5a2ltQGJhZW1pbi5jb210AAnquYDrsLDrr7w=";
		byte[] serializedMember = Base64.getDecoder().decode(base64Member);
		
		try(
				ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember))
			{
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				// 역직렬화된 Member 객체를 읽어온다.
				Object objectMember = ois.readObject();
				Member member = (Member) objectMember;
				System.out.println(member);
			}
		}
	}
	
}
