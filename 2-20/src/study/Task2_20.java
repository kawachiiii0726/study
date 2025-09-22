package study;

public class Task2_20 {

	public static void main(String[] args) {
		//④子クラスを元にしたインスタンスを作成して下さい。(インスタンス名：child)
		Child children= new Child();
		//⑤インスタンスchildでcallNameメソッドを呼び出して下さい。
		children.callName();
		//⑥インスタンスchildでupdateメソッドを呼び出して下さい。
		children.update();
		//⑦オーバーロードされたargumentメソッドを呼び出し解答画像になるように出力して下さい。
		children.argument();
		children.argument(1);
		children.argument(1,1);
	}

}