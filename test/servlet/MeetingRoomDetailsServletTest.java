package servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.TestDataBase;
import common.TestServlet;
import model.MeetingRoom;

public class MeetingRoomDetailsServletTest extends TestServlet {


	@Test
	public void 詳細の表示に成功する() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story06/MeetingRoomDetailsServlet_test.xls");

		// POSTメソッドを指定
		setPost();

		//入力値を設定
		webRequest.setParameter("Room", "総合研究棟6階会議室");

		// Servletを呼び出す。
		callServlet();

		// RequestにMeetingRoomオブジェクトが保存されていること（nullではないこと）を確認
		assertThat(request.getAttribute("MeetingRoom"),notNullValue());

		// RequestからMeetingRoomオブジェクトを読み込み
		MeetingRoom meetingRoom=(MeetingRoom)request.getAttribute("MeetingRoom");

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(meetingRoom.getRoom(),is("総合研究棟6階会議室"));
//		assertThat(meetingRoom.getSpace(),is(10));
//		assertThat(meetingRoom.getCapacity(),is(020));
//		assertThat(meetingRoom.getExtensionNum(),is(01111));
//		assertThat(meetingRoom.getProjector(),is(01));
//		assertThat(meetingRoom.getScreen(),is(01));
//		assertThat(meetingRoom.getWhiteboard(),is(01));
//		assertThat(meetingRoom.getInputTerminal(),is(01));
		assertThat(meetingRoom.getSpace(), is(10.0F));
		assertThat(meetingRoom.getCapacity(), is(20));
		assertThat(meetingRoom.getExtensionNum(), is(1111));
		assertThat(meetingRoom.getProjector(), is(1));
		assertThat(meetingRoom.getScreen(), is(1));
		assertThat(meetingRoom.getWhiteboard(), is(1));
		assertThat(meetingRoom.getInputTerminal(), is(1));


	}

	@Test
	public void 詳細の表示に失敗する() throws Exception {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story06/MeetingRoomDetailsServlet_test.xls");

		// POSTメソッドを指定
		setPost();
		// テキストボックスに入力値を設定
		webRequest.setParameter("Room", "部屋");

		// Servletを呼び出す。
		callServlet();

		// RequestにMeetingRoomオブジェクトが保存されていないこと（nullであること）を確認
		assertThat(request.getAttribute("MeetingRoom"),nullValue());

	}

}
