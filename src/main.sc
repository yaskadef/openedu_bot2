require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: /hello
        q!: $regex</hello>
        q!: * (привет/здравствуй*/~добрый (~утро/~вечер/~день/~ночь)/при*/хай/зд*) *
        a: привет
        
    state: /weather
        q!: $regex</weather>
        q!: * (~какой ~погода*/~какая ~сегодня/~завтра погода*/(~сегодня/~завтра) будет дождь*/сколько градусов*/какая температура*/сколько будет градусов*/какая будет температура*/сколько сегодня градусов*/~какой*/температура*/~какая*/прогноз*) *
        a: Норм погода
        
    state: /currency
        q!: $regex</currency>
        q!: * (~курс валют*/курс (~доллар/~евро/~фунт/~рубль/~валюта)/~какой*/сколько*/курс*/цена*/стоимост*) *
        a: деньги стоят денег
        
    state: /NoMatch
        q!: $regex</NoMatch>
        a: Не соответствие!

    state: Bye
        intent!: /пока
        a: Пока пока

    state: CatchAll
        q!:!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: NoMatch2
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}