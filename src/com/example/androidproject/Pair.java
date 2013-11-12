/*	Pair.java
 * 	Class to hold an image/string pair
 * 	Last Modified 12/11/2013	by Daniel
 */

package com.example.androidproject;

public class Pair {

	// private variables
	private int _id;
	private int _stringId;		//string resource ID
	private int _imageId;		//image resource ID
	
	//constructor
	Pair()
	{
		
	}
	
	//constructor
	Pair(int id, int stringId, int imageId)
	{
		this._id = id;
		this._stringId = stringId;
		this._imageId = imageId;
	}
	
	//constructor
	Pair(int stringId, int imageId)
	{
		this._stringId = stringId;
		this._imageId = imageId;
	}
	
	//ID getter
	public int getId()
	{
		return this._id;
	}
	
	//ID setter
	public void setId(int id)
	{
		this._id = id;
	}
	
	//string ID getter
	public int getStringId()
	{
		return this._stringId;
	}
	
	//string ID setter
	public void setStringId(int stringId)
	{
		this._stringId = stringId; 		
	}
	
	//image ID getter
	public int getImageId()
	{
		return this._imageId;
	}
	
	//image ID setter
	public void setImageId(int imageId)
	{
		this._imageId = imageId;
	}
	
}

