# ApiMarsRover

###Endpoints

```
GET /status
```
Return the current position and battery charge.

```
GET /text
```
Return a random text in english.

```
POST /move?direction:right/left/front/back&distanceMeters:$meters
```
Move Rover in the indicated direction and distance. Spend 1% battery every meter

```
POST /standStillCharging
```
Charge the battery, 1% every 2 seconds.

```
POST /ultraFastCharge
```
Charges the battery up to 100%

