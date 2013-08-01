package com.billhorvath.radiatrix.types;

/**
Names the three axes used to define a 3D space. 
<p>Several name variants are included to accommodate different reference systems, such that:</p>
<ul>
	<li>X = ABCISSA = LATERAL</li>
	<li>Y = ORDINATE = VERTICAL</li>
	<li>Z = APPLICATE = HORIZONTAL</li>
</ul>
*/
public enum Axis{
	X, Y, Z,
	ABCISSA, ORDINATE, APPLICATE,
	LATERAL, VERTICAL, HORIZONTAL
}
