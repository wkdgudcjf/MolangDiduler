package diduler.model.diary;


import java.awt.Image;

import diduler.model.diduler.DidulerModify;
import diduler.model.*;

public interface DiaryModify extends DidulerModify {

	public boolean modify(Diary oldDiary, Diary newDiary);
	public boolean modify(Diary diary, DiaryInfo field, String fieldContent);
	public boolean modify(Diary diary, DiaryInfo field, boolean fieldContent);
	

}
