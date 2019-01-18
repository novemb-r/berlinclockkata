# Berlin Clock Kata

Berlin clock converter project

# Usage

To convert digital time to berlin clock time, just use the function `setDate(hours, minutes, seconds)` :
    BerlinClockConverter().setDate(22 ,26 ,11 )

It will return you a BerlinClockConverter which you can use to get the converted time:
`berlinClockConverter.toString()` return the complete berlin time

The differents attributes of the BerlinClockConverter contains all the converted row:
- berlinClockConverter.convSecondRow
- berlinClockConverter.convSingleMinRow
- berlinClockConverter.convFiveMinRow
- berlinClockConverter.convSingleHoursRow
- berlinClockConverter.convFiveHoursRow

To convert berlin clock time to digital time, use the function `parse(berlinTime)` which return the digital time:
    BerlinClockConverter().parse("ORROOROOOYYRYYRYOOOOYYOO")