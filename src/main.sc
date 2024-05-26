require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        q!: $regex</hello>
        q!: * (привет/здравствуй*/~добрый (~утро/~вечер/~день/~ночь)) *
        a: привет
        
    state: weather
        q!: $regex</weather>
        a: Норм погода
        
    state: currency
        q!: $regex</currency>
        a: деньги стоят денег
        
    state: NoMatch
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