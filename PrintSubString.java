package nuaa.lily;

public class PrintSubString {
	public static void printSubAll(char[] str,int i,String res){
		if(i == str.length){
			System.out.println(res);
			return;
		}
		printSubAll(str, i+1, res);
		printSubAll(str, i+1, res + String.valueOf(str[i]));
	}
	public static void  printAll(char[] str, int start, int end){
		
		if(end <= 1){
			return;
		}
		if(start == end){
			for(int i = 0 ; i < str.length; i++){
				System.out.print(str[i]);
			}
			System.out.println();
		}else{
			for(int i = start; i <= end; i++){
				swap(str,i,start);
				printAll(str, start+1, end);
				swap(str,i,start);
			}
		}		
	}
	public static void swap(char[] str, int i, int j){
		char tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}
	public static void main(String[] args) {
		String test = "abc";
		printSubAll(test.toCharArray(), 0, "");
		System.out.println();
		printAll(test.toCharArray(), 0, test.toCharArray().length-1);
	}
}
