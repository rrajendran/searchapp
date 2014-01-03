package com.capella.searchapp.controller.model;

import java.io.Serializable;

public interface DomainObject extends Serializable {
	String getKey();
	String getObjectKey();
}