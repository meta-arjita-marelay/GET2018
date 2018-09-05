package com.metacube.advertismentwebservices.Common;

/**
 * Enums for different result status 
 * INSERTED , if data is inserted inrespective tables 
 * UPDATED if data is successfully updated in tables
 * DELETED if data is successfully deleted from table
 * DUPLICATE if data which user trying to insert is already in table 
 * NOT_FOUND for data which user is trying to manipulate is not found in tables 
 * INVALID if no category given for advertisement doesn't exist error if there is some error in authorization
 */
public enum Status {
	INSERTED, UPDATED, DELETED, DUPLICATE, NOT_FOUND, INVALID, ERROR;
}