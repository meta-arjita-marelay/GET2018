package com.metacube.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public JavaCollection javaCollection() {
		JavaCollection javaCollection = new JavaCollection();
		List<String> addressList = new ArrayList<String>();
		addressList.add("India");
		addressList.add("Pakistan");
		addressList.add("USA");
		addressList.add("USA");
		javaCollection.setAddressList(addressList);

		Set<String> addressSet = new HashSet<String>();
		addressSet.add("India");
		addressSet.add("Pakistan");
		addressSet.add("USA");
		addressSet.add("USA");
		javaCollection.setAddressSet(addressSet);

		Map<String, Double> addressMap = new HashMap<String, Double>();
		addressMap.put("India", 1.0);
		addressMap.put("Pakistan", 2.0);
		addressMap.put("USA", 3.0);
		addressMap.put("USA", 4.0);
		javaCollection.setAddressMap(addressMap);

		return javaCollection;
	}
}
