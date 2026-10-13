# Product Filter and Sort REST API Task

Implement REST APIs that filter and sort a collection of products.

The project already provides the required model classes. Complete the REST service implementation so the provided unit tests pass.

## Product Model

Each product record contains:

- `barcode`: unique product identifier, `String`
- `price`: product price, `Integer`
- `discount`: discount percentage, `Integer`
- `available`: availability status, `0` or `1`

The sample data also includes fields such as `item` and `category`; preserve them if they are part of the provided model.

Example products:

```json
[
  {
    "barcode": "74001755",
    "item": "Ball Gown",
    "category": "Full Body Outfits",
    "price": 3548,
    "discount": 7,
    "available": 1
  },
  {
    "barcode": "74002423",
    "item": "Shawl",
    "category": "Accessories",
    "price": 758,
    "discount": 12,
    "available": 1
  }
]
```

## Endpoint: Filter Products By Price

```http
GET /filter/price/{initial_range}/{final_range}
```

Return all products whose `price` is between `initial_range` and `final_range`.

Expected behavior:

- Return HTTP `200` when at least one product matches.
- Response body is a JSON array of matching products.
- Return HTTP `400` when no products match.

Example:

```http
GET /filter/price/750/900
```

Example response:

```json
[
  {
    "barCode": "74002423"
  }
]
```

## Endpoint: Sort Products By Price

```http
GET /sort/price
```

Return all products sorted by `price` in ascending order.

Expected behavior:

- Return HTTP `200`.
- Response body is a JSON array ordered by ascending price.
- The original statement says the response body should contain product names, but the embedded example returns objects containing `barCode`. Follow the provided tests/model expectations.

Example response:

```json
[
  {
    "barCode": "74002423"
  },
  {
    "barCode": "74001755"
  }
]
```

## Acceptance Criteria

- `GET /filter/price/{initial_range}/{final_range}` filters by inclusive price range.
- `GET /filter/price/{initial_range}/{final_range}` returns `400` if no products are found.
- `GET /sort/price` returns products sorted by ascending price.
- All provided unit tests pass.
