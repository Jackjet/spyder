package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {

		if(args.length < 2){
			System.err.println("ERROR");
			System.exit(0);
		}
		
		System.out.println("Input:\"" + args[0] + "\"");
		
		for(String arg : args){
			System.out.println("Regular expression: \"" + arg +"\"");
			Pattern p = Pattern.compile(arg);
//			Pattern.matches(regex, input)
			Matcher m = p.matcher(args[0]);
			while(m.find()){
				System.out.println("Match \"" + m.group() + "\" at positions " +  
						m.start() + "-" + (m.end() - 1));
			}
		}
	}

}

//hi  hi,HI,Hi,hI him,history,high
//\bhi\b
//������Ҫ�ҵ���hi���治Զ������һ��Lucy����Ӧ����\bhi\b.*\bLucy\b
//.����һ��Ԫ�ַ���ƥ����˻��з�����������ַ�
//.*����һ�����ζ�����������Ĳ��������е��ַ�
//\sƥ������Ŀհ׷��������ո��Ʊ��(Tab)�����з�������ȫ�ǿո��
//\wƥ����ĸ�����ֻ��»��߻��ֵ�
//[a-z0-9A-Z_]Ҳ��ȫ��ͬ��\w

/*
 * ������һ�������ӵı��ʽ��\(?0\d{2}[) -]?\d{8}��

��(���͡�)��Ҳ��Ԫ�ַ�������ķ��������ᵽ��������������Ҫʹ��ת�塣

������ʽ����ƥ�伸�ָ�ʽ�ĵ绰���룬
��(010)88886666����022-22334455����02912345678�ȡ����Ƕ�������һЩ�����ɣ�
������һ��ת���ַ�\(,���ܳ���0�λ�1��(?),Ȼ����һ��0���������2������(\d{2})��
Ȼ����)��-��ո��е�һ����������1�λ򲻳���(?)�������8������(\d{8})��
 * */


/*������ʽ��ķ�֦����ָ�����м��ֹ������������������һ�ֹ���Ӧ�õ���ƥ�䣬���巽������|�Ѳ�ͬ�Ĺ���ָ������������ף�û��ϵ�������ӣ�

0\d{2}-\d{8}|0\d{3}-\d{7}������ʽ��ƥ�����������ֺŷָ��ĵ绰���룺һ������λ���ţ�8λ���غ�(��010-12345678)��һ����4λ���ţ�7λ���غ�(0376-2233445)��*/

//	\d{1,3}ƥ��1��3λ������