<?php

function blocks()
{
	$array = array();
	$y = 0;
	$x = 0;
	$limit = 10;
	$half = $limit / 2;

	for($i = 0; $i < $limit; $i++)
	{
		// get the Y position
		if ($i % 5 == 0)
		{
			$y += 1;
		}
		$array[$i]["y"] = $y;

		// get the X position
		if ($i > $half)
		{
			$x = $i - $half;
		}
		else 
		{
			$x = $i;
		}
		$array[$i]["x"] = $x;
	}
	return $array;
}

$blocks = blocks();

var_dump($blocks);

?>
