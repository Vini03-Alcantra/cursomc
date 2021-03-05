package com.viniciusalcantaracursomc.resources.utils;

import java.util.ArrayList;
import java.util.List;

public class URL {
	public static List<Integer> decodeIntList(String s){
		String[] vet = s.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<vet.length; i++) {
			list.add(Integer.parseInt(vet[i]));
		}
		
		return list;
	}
}
