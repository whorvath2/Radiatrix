/**

<h2>The Radiatrix - A Columnar Multi-Dimensional Data Visualization Tool</h2>

<h3>Overview</h3>
<p>
The Radiatrix allows tuples (measures with any arbitrary number of degrees of freedom) that are taken repeatedly (either across or within subjects) to be visualized using a combination of polar and axial perspectives, i.e. arranged as a column or cylinder.
</p>

<h3>Specification</h3>
<p>
Each tuple is represented in a polar coordinate space. The circle is arbitrarily divided into equal-sized portions (&quot;slices&quot;) by as many lines (or radii) are there are degrees of freedom in the tuple. Each line is marked according to its units, and serve as a scale along which vectors are drawn for each data point, with the vectors originating in the center of the circle, and ending at the value corresponding to that in the tuple's data point.
</p>

<p>
In any arbitrary experiment resulting in a set of tuples, each set's data is plotted on its own polar coordinate space. The spaces from all or groups of the tuples can then be &quot;stacked&quot; into a column for visualization purposes, subject to the following restrictions:
</p>
<ul>
<li>Each space in the stack is aligned with those above and below it such that the same scale lines point in the same directions.</li>
<li>The order of the stack (top to bottom) may be altered to maximize the clarity of the relationships represented, so long as the reordering doesn't violate the logical tenets underlying the experiment. For example, in a set of tuples of measurements taken on one person, the polar spaces should likely be placed in temporal order in the stack.</li>
<li>If the measurement interval across subjects is a factor in the experiment, the ratio of the spacing between each space in the stack should correspond to the measurement interval.</li>
</ul>

@author Bill Horvath II
@version 1.0
*/
package com.billhorvath.radiatrix;
