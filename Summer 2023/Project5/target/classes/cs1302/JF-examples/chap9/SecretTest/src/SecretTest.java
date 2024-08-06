//********************************************************************
//  SecretTest.java       Java Foundations
//
//  Demonstrates the use of a formal interface.
//********************************************************************

public class SecretTest
{
	//-----------------------------------------------------------------
	//  Creates a Secret object and exercises its encryption.
	//-----------------------------------------------------------------
	public static void main(String[] args)
	{
		Secret hush = new Secret("Dawgs are National Champions!");
		System.out.println( "Open text:  " + hush );

		hush.encrypt();
		System.out.println( "Encrypted:  " + hush );

		hush.decrypt();
		System.out.println( "Decrypted:  " + hush);
	}
}
