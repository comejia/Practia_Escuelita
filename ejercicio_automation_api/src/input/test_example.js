

var fs = require('fs')

var request = require('request')





var id = '33796657';

var url = 'https://compliance.dev.xapo.com/v1/limit/check_array/';










var options = {

url: url,

agentOptions: {

cert: fs.readFileSync('xxxxx'),

key: fs.readFileSync('xxxxxx'),

ca: fs.readFileSync('xxxxxx')



},

headers: {

'Content-Type': 'application/json'

},

body:{

"operations": [

"XAPOAPP",// if can use the app

"NO_BTC_CURRENCY",// if can have FIAT

"BUY",// if can buy btc

"REQUEST_DEBIT_CARD",// request debit card

"NETWORKCASH",// can use people nearby

"BTC_ADDRESS",// if can see btc address

"WITHDRAW"//if can withdraw

],

"owner_type": 2,

"owner_id": id

},

json: true

}




request.post(options, function(err, resp, body) {

console.log(err)

console.log('-------------STAGING----------')

console.log(JSON.stringify(body))

console.log('-------------STAGING----------')

})

