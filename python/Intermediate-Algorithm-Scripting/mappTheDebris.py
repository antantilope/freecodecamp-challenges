
'''

Return a new array that transforms the elements' average altitude into their orbital periods (in seconds).

The array will contain objects in the format {name: 'name', avgAlt: avgAlt}.

You can read about orbital periods on Wikipedia.

The values should be rounded to the nearest whole number. The body being orbited is Earth.

The radius of the earth is 6367.4447 kilometers, and the GM value of earth is 398600.4418 km3s-2.

'''


from math import pi, sqrt,



def doCalcOrbitalPeriod(avgAlt):
    GM = 398600.4418
    earthRadius = 6367.4447
    return 2*pi * sqrt((pow((earthRadius + avgAlt), 3) / GM))


def orbitalPeriod(arr):
    return [{'name':obj['name'],
            'orbitalPeriod': round(doCalcOrbitalPeriod(orbitalPeriod))
            } for obj in arr]

  
orbitalPeriod([{'name' : "sputnik", 'avgAlt' : 35873.5553}])