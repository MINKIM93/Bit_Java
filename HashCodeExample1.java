class HashCodeExample1 {
	public static void main(String[] args) {
		String obj1 = new String("�츣�̿´�");
		String obj2 = new String("�츣�̿´�");
		if (obj1 == obj2)
			System.out.println("����");
		else
			System.out.println("�ٸ���");
		int hash1 = obj1.hashCode();
		int hash2 = obj2.hashCode();
		System.out.println(hash1);
		System.out.println(hash2);

	} // ������Ʈ Ŭ������ �ִ� hashCode()�� ������ ��ü�ּҸ� �̿� �ؼ�
	// ����ϱ� ������ ��ü�� �ּҰ� �ٸ��� �ٸ� hashCode() ���� ����� ����.
	// ��Ʈ�� Ŭ������ hashCode()�� ������ ���ڿ� �����͸� ������ ������
	// hashCode()�� ���ǵ��� �������̵� �Ǿ� �����ȴ�.
	

}
