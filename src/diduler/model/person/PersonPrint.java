package diduler.model.person;

import diduler.model.*;
/**
 * 사람정보를 콘솔에 print해주는 메소드를 모은 인터페이스
 * @author 장형철
 *
 */
public interface PersonPrint 
{
	/**
	 * 그륩전체를 print해주는 메소드
	 */
	void printList(); //전체
	/**
	 * 특정그륩을 print해주는 메소드
	 * @param groupName print할 그륩명
	 */
	void printList(String groupName); //그륩
	/**
	 * 조건에 맞는 사람들만 print해주는 메소드
	 * @param info enum타입 검색조건
	 * @param content 사람정보를 검색하는 조건
	 */
	void print(PersonInfo info,String content); //펄슨
	/**
	 * 특정 사람을 print해주는 메소드
	 * @param person print할 사람객체
	 */
	void print(Person person); //펄슨
}
