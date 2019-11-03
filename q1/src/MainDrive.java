
public class MainDrive {
	public static void main(String[] args) {

		try {
				Table table = new Table(args);
				System.out.print(table.print());

		} catch (NumberFormatException e) {
			System.out.print("Not are number");
		}catch (Exception e) {
			System.out.print("Unexcepted Error : " + e.getMessage());
		}
	}
}
