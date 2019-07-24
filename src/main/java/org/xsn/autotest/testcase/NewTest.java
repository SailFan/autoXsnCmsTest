package org.xsn.autotest.testcase;

import java.util.Iterator;
import java.util.LinkedList;

import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  LinkedList<String> list = new LinkedList<String>();
	  list.add("liu");
	  list.add("wen");
	  Iterator<String> iterator = list.iterator();
	  
	  while (iterator.hasNext()) {
		if (iterator.next().equals("liu")) {
			System.out.println(iterator);
		}
		
	}
  }
}
