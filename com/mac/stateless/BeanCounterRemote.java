package com.mac.stateless;

import javax.ejb.Remote;

@Remote
public interface BeanCounterRemote {
	int getCount();
	void addCount();
}
