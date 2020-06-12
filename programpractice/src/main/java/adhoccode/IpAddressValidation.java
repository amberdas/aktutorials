package adhoccode;

import java.util.Scanner;

public class IpAddressValidation {

	public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
		String ipType="Neither";
		int numberOfInput=input.nextInt();
		String[] ipPartsArray;
		int count;
		input.nextLine();
		for(int i=0;i<numberOfInput;i++)
		{
			String ipString=input.nextLine();
			count=0;
			if(ipString.contains(".") && !ipString.contains(":"))
			{
				ipPartsArray=ipString.split("\\.");
				if(ipPartsArray.length==4)
				{
					for(int j=0;j<ipPartsArray.length;j++)
					{
						if(!ipPartsArray[j].matches("^[0-9]*$")||Integer.parseInt(ipPartsArray[j])>255 ||Integer.parseInt(ipPartsArray[j])<0)
						{
							break;
						}
						else
						{
							count++;
						}
					}
				}
				ipType=count==4?"IPv4":"Neither";
                
			}
			else if(!ipString.contains(".") && ipString.contains(":"))
			{
				ipPartsArray=ipString.split(":");
				if(ipPartsArray.length==8)
				{
					for(int j=0;j<ipPartsArray.length;j++)
					{
						if(ipPartsArray[j].matches("^[a-fA-F0-9]*$"))
						{
							count++;
						}
					}
				}
				ipType=count==8?"IPv6":"Neither";
                
			}
		System.out.println(ipType);	
		}
    }

}
