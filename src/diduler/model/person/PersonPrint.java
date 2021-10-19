package diduler.model.person;

import diduler.model.*;
/**
 * ��������� �ֿܼ� print���ִ� �޼ҵ带 ���� �������̽�
 * @author ����ö
 *
 */
public interface PersonPrint 
{
	/**
	 * �׷���ü�� print���ִ� �޼ҵ�
	 */
	void printList(); //��ü
	/**
	 * Ư���׷��� print���ִ� �޼ҵ�
	 * @param groupName print�� �׷���
	 */
	void printList(String groupName); //�׷�
	/**
	 * ���ǿ� �´� ����鸸 print���ִ� �޼ҵ�
	 * @param info enumŸ�� �˻�����
	 * @param content ��������� �˻��ϴ� ����
	 */
	void print(PersonInfo info,String content); //�޽�
	/**
	 * Ư�� ����� print���ִ� �޼ҵ�
	 * @param person print�� �����ü
	 */
	void print(Person person); //�޽�
}
