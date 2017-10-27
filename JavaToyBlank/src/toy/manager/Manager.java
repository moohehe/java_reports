package toy.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import toy.vo.Toy;

/**
 * 장난감 정보를 관리하는 클래스
 */
public class Manager {
	private final String FILE_NAME = "toyList.dat";
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	FileInputStream fis = null;
	ObjectInputStream ois = null;
	private ArrayList<Toy> toyList;		// 장난감 리스트
	private File f= null;
	/**
	 * Constructor
	 */
	public Manager() {
		f = new File(FILE_NAME);
		if(f.exists()){
			loadFile();
		} else {
			toyList = new ArrayList<Toy>();
		}
	}
	
	/**
	 * toyList.dat를 저장한다
	 */
	public void saveFile() {
		try
		{
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(toyList);
		} catch (Exception e)
		{
			System.out.println("파일저장 실패");
			e.printStackTrace();
		} finally
		{
			if (oos != null)
				try
				{
					oos.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			if (fos != null)
				try
				{
					fos.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * toyList.dat를 불러온다
	 */
	public void loadFile() {
		try
		{
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			 
			toyList = (ArrayList<Toy>) ois.readObject();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally {
			if (fis != null)
				try
				{
					fis.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			if (ois != null)
				try
				{
					ois.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		}
		
	}
	
	/**
	 * 장난감을 저장한다. 장난감은 code에 의해 분류되고 같은 code는 사용할 수 없다.
	 * @param toy 저장할 장난감 정보
	 * @return 저장 여부
	 */
	public boolean insert(Toy toy) {

		Toy insert_f = search(toy.getCode());
		if (insert_f != null)
			return false; // 동일한 값이 있으면 등록실패!
		
		boolean canAdd = toyList.add(toy);
		
		return canAdd;
	}
	
	/**
	 * code를 통해 장난감을 찾는다. 코드가 일치하는 장난감을 찾으면 그것을 반환한다.
	 * @param code 검색할 장난감 코드
	 * @return 일치하는 장난감 정보
	 */
	public Toy search(String code) {
		for (Toy t : toyList)
		{
			if (code.equals(t.getCode()))
				return t;
		}
		return null;
	}

	/**
	 * code를 통해 장난감을 삭제한다. 코드가 일치하는 장난감을 찾으면 삭제한다. 
	 * @param code 삭제할 장난감 코드
	 * @return 삭제 여부
	 */
	public boolean delete(String code) {
		for (Toy t : toyList)
		{
			if (code.equals(t.getCode()))
			{
				toyList.remove(t);
				return true;
			}
		}
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
