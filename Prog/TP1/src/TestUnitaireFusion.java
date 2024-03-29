package esir.tp1;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

// test fusion
public class TestUnitaireFusion {

	public static void main(String[] args) {
		JUnitCore.runClasses(TestUnitaireFusion.class);
	}

	public int []    AppelAlgo(int [] t1, int [] t2) {
		//------------------------------------------------
		// À modifier selon le nom de la classe à tester
		//------------------------------------------------
		return Main.interclassementTableaux(t1, t2, t1.length, t2.length);
	}

	//------------------------------------------------------------
	// normalement, rien à modifier plus bas
	// ------------------------------------------------------------

	@Test(timeout=1000)
	public void testFusion_t1t2_vides()
	{
		System.out.print("\nTest fusion deux tableaux vides		: ");
		int [] t1 = { };
		int [] t2 = {  };
		int [] resu = {  };
		int [] t3 = AppelAlgo(t2, t1);
		Assert.assertArrayEquals(resu, t3);
		System.out.println("test réussi");
	}

	@Test(timeout=1000)
	public void testFusion_t1_vide() {
		System.out.print("\nTest fusion premier tableau vide	: ");
		int [] t1   = {  };
		int [] t2   = {
			0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
		};
		int [] resu = Arrays.copyOf(t2, t2.length);
		int [] t3   = AppelAlgo(t1, t2);
		Assert.assertArrayEquals(resu, t3);
		System.out.println("test réussi");
	}

	@Test(timeout=1000)
	public void testFusion_t2_vide() {
		System.out.print("\nTest fusion deuxième tableau vide	: ");
		int [] t1   = {
			0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
		};
		int [] t2   = {  };
		int [] resu = Arrays.copyOf(t1, t1.length);
		int [] t3   = AppelAlgo(t1, t2);
		Assert.assertArrayEquals(resu, t3);
		System.out.println("test réussi");
	}

	@Test(timeout=1000)
	public void testFusion_bizarre() {
		System.out.print("\nTest fusion bizarre			: ");
		int [] t1 = {
			0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12
		};
		int [] t2 = {
			12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
		};
		int [] resu = {
			0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
		};
		int [] t3 = AppelAlgo(t1, t2);
		Assert.assertArrayEquals(resu, t3);
		System.out.println("test réussi");
	}

	@Test(timeout=1000)
	public void testFusion_normal() {
		System.out.print("\nTest fusion cas normal			: ");
		int [] t1 = {
			0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
		};
		int [] t2 = {
			-5, 6, 15, 15, 15, 15, 15, 15, 19, 22, 22, 26, 29, 31, 35, 802, 802, 802, 823, 830, 999, 1500
		};
		int [] resu = {
			-5, 0, 1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 19, 20, 21, 21, 22, 22, 22, 22, 23, 24, 25, 26, 27, 28, 29, 29, 29, 30, 31, 31, 35, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 802, 802, 802, 805, 813, 823, 823, 830, 830, 848, 871, 896, 921, 933, 946, 999, 1500
		};
		int [] t3 = AppelAlgo(t1, t2);
		Assert.assertArrayEquals(resu, t3);
		System.out.println("test réussi");
	}
}
