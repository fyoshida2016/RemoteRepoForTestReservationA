package db;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.TestDataBase;
import model.MeetingRoom;

public class MeetingRoomManagerTest {

	@Test
	public void ログイン名とパスワードでレコードを取得_成功() {
		// データベースにテストデータを挿入
		TestDataBase db = new TestDataBase();
		db.setTestData("./testdata/story06/dbaccess_test.xls");

		// 登録済みのログイン名とパスワードを指定して、データベースからオブジェクトを読み込み
		MeetingRoomManager mm = new MeetingRoomManager();
		MeetingRoom room = mm.getMeetingRoom("総合研究棟6階会議室");

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック

		System.out.println(room.getRid());
		assertThat(room.getRid(), is(1));
		assertThat(room.getRoom(), is("総合研究棟6階会議室"));
		assertThat(room.getSpace(), is(10.0F));
		assertThat(room.getCapacity(), is(20));
		assertThat(room.getExtensionNum(), is(1111));
		assertThat(room.getProjector(), is(1));
		assertThat(room.getScreen(), is(1));
		assertThat(room.getWhiteboard(), is(1));
		assertThat(room.getInputTerminal(), is(1));

	}


	@Test
	public void ログイン名とパスワードでレコードを取得_失敗() {
		// データベースにテストデータを挿入
		TestDataBase db = new TestDataBase();
		db.setTestData("./testdata/story01/Story06TestData.xls");

		// 登録されていないログイン名とパスワードを指定して、データベースからオブジェクトを読み込み
		MeetingRoomManager mm = new MeetingRoomManager();
		MeetingRoom room = mm.getMeetingRoom("機械・建設3号棟5階経営情報専門実験室");


		// 読み込んだオブジェクトがNULLになっていることを確認
		assertThat(room, nullValue());

	}

}
