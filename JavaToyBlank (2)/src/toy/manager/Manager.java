package toy.manager;

import java.io.File;
import java.util.ArrayList;

import toy.vo.Bicycle;
import toy.vo.Drone;
import toy.vo.GameConsole;
import toy.vo.Toy;

/**
 * 장난감 정보를 관리하는 클래스
 */
public class Manager {
	private final String FILE_NAME = "toyList.dat";
	
	private ArrayList<Toy> toyList;		// 장난감 리스트

	
	/**
	 * Constructor
	 */
	public Manager() {
		if(new File(FILE_NAME).exists()){
			loadFile();
		} else {
			toyList = new ArrayList<Toy>();
		}
	}
	
	/**
	 * toyList.dat를 저장한다
	 */
	public void saveFile() {
		// CODE HERE
	}
	
	/**
	 * toyList.dat를 불러온다
	 */
	public void loadFile() {
		// CODE HERE
	}
	
	/**
	 * 장난감을 저장한다. 장난감은 code에 의해 분류되고 같은 code는 사용할 수 없다.
	 * @param toy 저장할 장난감 정보
	 * @return 저장 여부
	 */
	public boolean insert(Toy toy) {
		// CODE HERE
		return true;
	}
	
	/**
	 * code를 통해 장난감을 찾는다. 코드가 일치하는 장난감을 찾으면 그것을 반환한다.
	 * @param code 검색할 장난감 코드
	 * @return 일치하는 장난감 정보
	 */
	public Toy search(String code) {
		// CODE HERE
		return null;
	}

	/**
	 * code를 통해 장난감을 삭제한다. 코드가 일치하는 장난감을 찾으면 삭제한다. 
	 * @param code 삭제할 장난감 코드
	 * @return 삭제 여부
	 */
	public boolean delete(String code) {
		// CODE HERE
		return false;
	}

	/**
	 * 장난감 리스트를 얻는다
	 * @return 장난감 리스트
	 */
	public ArrayList<Toy> getToyList() {
		return toyList;
	}
	
}
