package com.aurionpro.Guitar.model;

public enum Style {
A,F;
@Override
public String toString() {
	switch (this) {
	case A:
		return "A_Style";
	case F:
		return "F_Style";
	}
	return null;
}
}
