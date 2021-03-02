# Stable vs UnStable
unstable sort algorithm doesn't reserve the original/relative ordering of duplicate items.
stable sort algorithm reserves the original/relative ordering of duplicate items.
this makes a big difference if we store objects by duplicate keys such as names, ages and etc.

a stable sort is perferable.

bubble sort is a stable sort since we only swap items when one is greather or smaller than the other. 
Never swap two duplicate items when they're equal. We can accidently turn a stable sort into unstable swap if we swap two duplicate items when they're equal.
