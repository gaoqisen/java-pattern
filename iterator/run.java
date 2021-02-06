package study.iterator;

public class run {
	public static void main(String args[]) {
		DoctorZhang zhang =new DoctorZhang();
		DoctorLi li = new DoctorLi();
		PetShop ps =new PetShop(zhang, li);
		ps.printAnimal();
		
		// java.util 迭代器使用
		System.out.println("++++++++++++++++java.util 迭代器 ");
		DoctorZhangJavaUtil zhangJavaUtil =new DoctorZhangJavaUtil();
		DoctorLiJavaUtil liJavaUtil = new DoctorLiJavaUtil();
		PetShopJavaUtil psJavaUtil =new PetShopJavaUtil(zhangJavaUtil, liJavaUtil);
		psJavaUtil.printAnimal();
	}
}
