package model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MeetingRoomTest {

	@Test
	public void test() {
		MeetingRoom room=new MeetingRoom();
		room.setRid(1);
		room.setRoom("総合研究棟6階会議室");
		room.setSpace(10);
		room.setCapacity(20);
		room.setExtensionNum(1111);
		room.setProjector(1);
		room.setScreen(1);
		room.setWhiteboard(1);
		room.setInputTerminal(1);

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

}
