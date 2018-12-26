package src;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class StringCount
{

	/**
	 * ������
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		String ss = null;
		System.out.println("�������ַ���,�ԡ�.��������");
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = br.readLine();
			ss = s.substring(0, s.indexOf("."));// ע��substring������������ҿ�������ss�в�����"."
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		String[] temp = ss.split("#");
		int n = temp.length;
		System.out.println("�ַ�������Ϊ" + n);

		int max = -1;
		int min = 100000000;
		String maxS = null, minS = null;

		for (int i = 0; i < n; i++)
		{
			if (temp[i].length() > max)
			{
				max = temp[i].length();
				maxS = temp[i];
			}
			if (temp[i].length() < min)
			{
				min = temp[i].length();
				minS = temp[i];
			}
		}

		System.out.println("��ַ���Ϊ" + maxS + "�����Ϊ" + max);
		System.out.println("����ַ���Ϊ" + minS + "�����Ϊ" + min);

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++)
		{
			list.add(temp[i]);
		}

		Collections.sort(list);

		try
		{
			FileWriter fw = new FileWriter("3.txt");
			for (int i = 0; i < n; i++)
			{
				fw.write(list.get(i) + "\n");// ���ź�����ַ�������д���ļ�
			}
			fw.write("��ַ���Ϊ" + maxS + "�����Ϊ" + max);
			fw.write("����ַ���Ϊ" + minS + "�����Ϊ" + min);
			fw.write("�ַ�������Ϊ" + n);
			fw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
