package db;

import java.sql.ResultSet;
import java.util.LinkedList;

import common.DataBaseManager;
import model.MeetingRoom;


public class MeetingRoomManager extends DataBaseManager{

	protected Object copyRecord(ResultSet rs) throws Exception{
		MeetingRoom mr = new MeetingRoom();
		mr.setRid(rs.getInt("RID"));
		mr.setRoom(rs.getString("Room").trim());
		mr.setSpace(rs.getFloat("Space"));
		mr.setCapacity(rs.getInt("capacity"));
		mr.setExtensionNum(rs.getInt("extensionNum"));
		mr.setProjector(rs.getInt("projector"));
		mr.setScreen(rs.getInt("screen"));
		mr.setWhiteboard(rs.getInt("whiteboard"));
		mr.setInputTerminal(rs.getInt("inputTerminal"));
		return mr;
	}

	public MeetingRoom getMeetingRoom(String Room){
		String sql = "";
		sql += "Select * from MeetingRoomInfo Where ";
		sql += "Room = '"+ Room +"'";

		return (MeetingRoom)getRecord(sql);
	}
}
