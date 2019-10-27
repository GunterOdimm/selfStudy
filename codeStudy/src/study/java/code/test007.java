package study.java.code;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class test007 {
	public static void main(String[] args) throws IOException {
		Member member = new Member("김배민", "deliverykim@baemin.com", 25);
		byte[] serializedMember;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(member);
				// serializedMember -> 직렬화된 member 객체
				serializedMember = baos.toByteArray();
			}
		}
		// 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
		System.out.println(Base64.getEncoder().encodeToString(serializedMember));
		
	}

	// 직렬화 예제에서 생성된 base64 데이터
	}