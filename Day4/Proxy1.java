package aPatternsCode;

interface Icon {
	void display();
}
class ImageIcon implements Icon {
	@Override
	public void display() {
		System.out.println("Real image diplayed");
	}
}
class ImageProxy implements Icon {
	Icon realImage;
	public ImageProxy() {
		new Thread(()-> downloadImage()).start();
	}
	void downloadImage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		realImage = new ImageIcon();
	}
	@Override
	public void display() {
		if (realImage != null)
			realImage.display();
		else
			System.out.println("Dummy image diplayed");
	}
}
public class Proxy1 {

	public static void main(String[] args) throws InterruptedException {
		var i = new ImageProxy();
		while (true) {
			i.display();
			Thread.sleep(200);
		}
	}
}
