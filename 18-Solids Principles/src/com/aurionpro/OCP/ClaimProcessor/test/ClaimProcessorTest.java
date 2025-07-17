package com.aurionpro.OCP.ClaimProcessor.test;

import com.aurionpro.OCP.ClaimProcessor.model.Health;
import com.aurionpro.OCP.ClaimProcessor.model.Life;
import com.aurionpro.OCP.ClaimProcessor.model.Property;
import com.aurionpro.OCP.ClaimProcessor.model.Travel;
import com.aurionpro.OCP.ClaimProcessor.model.Vehicle;

public class ClaimProcessorTest {
public static void main(String[] args) {
	Claim claim = new Claim();
	claim.insuranceClaim(new Health());
	claim.insuranceClaim(new Life());
	claim.insuranceClaim(new Property());
	claim.insuranceClaim(new Travel());
	claim.insuranceClaim(new Vehicle());
	
	
}
}
