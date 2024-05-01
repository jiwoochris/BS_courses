from jbinmod import *

with open("binance_key.txt") as f:
    lines = f.readlines()
    api_key = lines[0].strip()
    secret  = lines[1].strip()

binance = ccxt.binance(config={
    'apiKey': api_key, 
    'secret': secret,
    'enableRateLimit': True,
    'options': {
        'defaultType': 'future'
    }
})

symbol = "BTC/USDT"
market = binance.market(symbol)
leverage = 3

resp = binance.fapiPrivate_post_leverage({
    'symbol': market['id'],
    'leverage': leverage
})

balance = binance.fetch_balance()
usdt = balance['total']['USDT']
hold_flag = False 
position = None

post_message("Start binance auto trading program.")

while True:
    
    now = datetime.datetime.now()
    
    if hold_flag == False:
        if now.minute % 15 == 0 and 1 <= now.second <= 10:
            signal = get_signal(symbol)
            position = signal['symbol']

            before_krw = binance.fetch_balance()['total']['USDT']
            
            amount = enter_position(binance, symbol, position)
            buy_price = binance.fetch_ticker(symbol)['last']

            #post_message(f"[binance][long] {ret['market']} {ret['price']}")
            hold_flag = True

        if (now.hour == 10 and now.minute == 0 and 0 < now.second < 2) or (now.hour == 22 and now.minute == 0 and 0 < now.second < 2):
            post_message(f"[binance][동작중] Waiting next candle")
            time.sleep(0.8)

    elif hold_flag == True:
        if position == 'long':
            if binance.fetch_ticker(symbol)['last'] > buy_price * 1.005:
                exit_position(binance, symbol, position)
            
            elif binance.fetch_ticker(symbol)['last'] < buy_price * 0.996:
                exit_position(binance, symbol, position)

        elif position == 'short':
            if binance.fetch_ticker(symbol)['last'] < buy_price * 0.995:
                exit_position(binance, symbol, position)

            elif binance.fetch_ticker(symbol)['last'] > buy_price * 1.006:
                exit_position(binance, symbol, position)

        after_krw = binance.fetch_balance()['total']['USDT']

        if after_krw > before_krw:
            결과 = "익절"
        else:
            결과 = "손절"
        
        수익률 = after_krw / before_krw * 100 - 100

        post_message(f"[binance][{결과}] {수익률} % 잔고 : {after_krw}")
        hold_flag = False
        
    if (now.hour == 10 and now.minute == 0 and 0 < now.second < 2) or (now.hour == 22 and now.minute == 0 and 0 < now.second < 2):
        post_message(f"[binance][동작중] Holding {symbol} {position}")
        time.sleep(0.8)

    time.sleep(0.1)