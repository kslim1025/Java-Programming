package src;

/**
 * �廪��ѧ���ѧԺ����������Կ�����ϰ�� ��Ŀ:���д�����������������⡣��֪n������һ���ſ���nΪ�û������
 * �������������������ҷֱ���źţ�1��2��... ...��n��ÿ����Ҳ�� ��ţ��ֱ�Ҳ��1��2��... ...��n����Ҫ����n����ȫ��������n������
 * �У����㣺ÿ�����ӷ���1������ĺŲ����������ڵ����ӵĺ���ͬ ���������������ڵ������Ų������ڡ����磬�������������������
 * �������ŷֱ�Ϊ9��10�����ǲ�����ġ���������з���Ҫ��ķ��� ��ʽ������ÿ�ַ���Ҫ��ķ���ʽ����Ӧ�����ÿ�������е���ţ���
 * 
 * @author THSS MSE08 HUANGBIN
 * 
 */
public class BascketBallSort
{
	// ����
	private String[] basckets;
	// ����
	private String[] balls;

	public BascketBallSort(int n)
	{
		// ��ʼ������
		basckets = new String[n];
		for (int i = 0; i < n; i++)
			basckets[i] = String.valueOf(i + 1);

		// ��ʼ������
		balls = new String[n];
		for (int i = 0; i < n; i++)
			balls[i] = String.valueOf(i + 1);

		// ��n���������ȫ����
		perm(balls, 0, balls.length - 1);
	}

	// ��n���������ȫ���У����÷��β��Խ��еݹ����
	public void perm(String[] buf, int start, int end)
	{

		if (start == end)// ֻ��һ�������ȫ����ʱ������Ҫ�ٵݹ�
		{
			// ����Ƿ����Ҫ���������Ҫ�������
			if (check(buf))
			{
				for (int i = 0; i < buf.length; i++)
				{
					System.out.print(basckets[i] + "(" + buf[i] + ") ");
				}
				System.out.println();
			}
		}

		else
		{
			for (int i = start; i <= end; i++)
			{
				// ����i��startԪ�ص�ֵ
				String temp = buf[i];
				buf[i] = buf[start];
				buf[start] = temp;

				perm(buf, start + 1, end);// �ݹ�������ȫ����

				// ��ԭi��startԪ�ص�ֵ
				temp = buf[i];
				buf[i] = buf[start];
				buf[start] = temp;
			}
		}
	}

	// ��ÿһ��ȫ���н�����м�飬��֤���Ӻ�����Ų�һ����������Ų�����
	public boolean check(String tempBalls[])
	{
		// ��������ӺŲ�����ͬ
		for (int i = 0; i < tempBalls.length; i++)
		{
			if (tempBalls[i].equals(basckets[i]))
			{
				return false;
			}
		}

		// ���������ڵ���Ų�������
		for (int i = 0; i < tempBalls.length - 1; i++)
		{
			if (Math.abs(Integer.parseInt(tempBalls[i]) - Integer.parseInt(tempBalls[i + 1])) == 1)
				return false;
		}
		return true;
	}
}
