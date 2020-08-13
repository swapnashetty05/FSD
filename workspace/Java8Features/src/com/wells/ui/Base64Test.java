package com.wells.ui;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Scanner;

import javax.xml.soap.SAAJResult;

public class Base64Test {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the Message");
		
		String msg = scan.next();
		
		Encoder encode = Base64.getEncoder();
		Decoder decode = Base64.getDecoder();
		
		String encodeMsg = encode.encodeToString(msg.getBytes());
		System.out.println(encodeMsg);
		
		String decodeMsg = new String(decode.decode(encodeMsg));
		System.out.println(decodeMsg);

	}

}
