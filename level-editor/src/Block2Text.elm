module Block2Text exposing (toText, toBlock)


import Dict
import AllDict


import World exposing
    ( Block(..)
    , BlockMaterial(..)
    , BlockShape(..)
    )


t2bList : List (Char, Block)
t2bList =
    [ (' ',  NoBlock)
    , ('#',  Block Earth Flat)
    , ('\\', Block Earth UpLeft)
    , ('/',  Block Earth UpRight)
    , (')',  Block Earth BridgeUpLeft)
    , ('(',  Block Earth BridgeUpRight)
    ]


t2b : Dict.Dict Char Block
t2b =
    Dict.fromList t2bList


swap : (a, b) -> (b, a)
swap (x, y) =
    (y, x)


ordBlock : Block -> Int
ordBlock block =
    let
        a =
            case block of
                NoBlock -> 0
                Block Earth _ -> 1
                Block Metal _ -> 2
        b = case block of
                NoBlock -> 0
                Block _ Flat -> 1
                Block _ UpRight -> 2
                Block _ UpLeft -> 3
                Block _ BridgeUpRight -> 4
                Block _ BridgeUpLeft -> 5
    in
        a * 100 + b


b2t : AllDict.AllDict Block Char Int
b2t =
    AllDict.fromList ordBlock (List.map swap t2bList)


toBlock : Char -> Result String Block
toBlock c =
    case Dict.get c t2b of
        Just b ->
            Ok b
        Nothing ->
            Err ("Unrecognised character '" ++ (String.fromChar c) ++ "'.")


toText : Block -> Char
toText b =
    case AllDict.get b b2t of
        Just c ->
            c
        Nothing ->
            Debug.crash "Unknown block!"