package com.MoreiraJunior.cloud.tema4.history;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.MoreiraJunior.cloud.tema4.operations.Operation;

@Component("history")
public class History {
	
	private static List<Operation> history = new ArrayList<>();
	
	public void addOperation(Operation operation) {
		history.add(operation);
	}
	
	public List<Operation> getHistory(){
		return Collections.unmodifiableList(history);
	}
	
	public void clearList() {
		history.clear();
	}
}
