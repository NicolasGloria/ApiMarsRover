package com.abaenglish.marsRover.utils;

public enum DirectionEnum {
	RIGHT("right"),
	LEFT("left"),
	FRONT("front"),
	BACK("back");
	
	private final String direction;

	DirectionEnum(String direction) {
        this.direction = direction;
    }
	
	public String getString() {
		return this.direction;
    }
	
	public static DirectionEnum forName(String direction) {
        for (DirectionEnum d : DirectionEnum.values()) {
            if (d.direction.equalsIgnoreCase(direction)) {
                return d;
            }
        }
        return null;
    }
	
	static public boolean isMember(String name) {
		DirectionEnum[] directions = DirectionEnum.values();
       for (DirectionEnum direction : directions)
           if (direction.direction.equals(name))
               return true;
       return false;
   }
}
