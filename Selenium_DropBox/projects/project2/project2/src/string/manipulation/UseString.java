package string.manipulation;

public class UseString {

	public static void main(String[] args) {
		String st = "NASA's Juno spacecraft sends back first image of Jupiter and its moons";
		
		System.out.println(st.toUpperCase());
		System.out.println(st.toLowerCase());
		System.out.println(st.length());
		System.out.println(st.charAt(50));
		System.out.println(st.replace('n', 'h'));

	}

}
